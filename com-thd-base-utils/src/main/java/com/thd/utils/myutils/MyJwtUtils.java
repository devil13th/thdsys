/** 
 * Class Description:########
 * Date : 2017年6月4日 上午10:40:45
 * Auth : wanglei 
*/  

package com.thd.utils.myutils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.thd.utils.myutils.bean.JwtClaims;

public class MyJwtUtils {
	public static String sign(JwtClaims claim,Map info) {
		
		if(claim.getSercurityStr() == null){
			throw new RuntimeException(" property named sercurityStr of claims can not be null");
		}
		final String issuer = claim.getIss();
		final String secret = claim.getSercurityStr();
		
		

		final JWTSigner signer = new JWTSigner(secret);
		final HashMap<String, Object> claims = new HashMap<String, Object>();
		/*
		iss(Issuser)：如果签发的时候这个claim的值是“a.com”，验证的时候如果这个claim的值不是“a.com”就属于验证失败；
		sub(Subject)：如果签发的时候这个claim的值是“liuyunzhuge”，验证的时候如果这个claim的值不是“liuyunzhuge”就属于验证失败；
		aud(Audience)：如果签发的时候这个claim的值是“['b.com','c.com']”，验证的时候这个claim的值至少要包含b.com，c.com的其中一个才能验证通过；
		exp(Expiration time)：如果验证的时候超过了这个claim指定的时间，就属于验证失败；
		nbf(Not Before)：如果验证的时候小于这个claim指定的时间，就属于验证失败；
		iat(Issued at)：它可以用来做一些maxAge之类的验证，假如验证时间与这个claim指定的时间相差的时间大于通过maxAge指定的一个值，就属于验证失败；
		jti(JWT ID)：如果签发的时候这个claim的值是“1”，验证的时候如果这个claim的值不是“1”就属于验证失败
		*/
		claims.put("iss", claim.getIss());
		claims.put("exp", claim.getExpire()); //单位是秒
		claims.put("iat", claim.getIat());
		claims.put("sub", claim.getSub());
		claims.put("aud", claim.getAud());
		
		/*if(info.get("iss") != null ||
			info.get("exp") != null ||
			info.get("iat") != null ||
			info.get("sub") != null ){
			throw new RuntimeException(" there is the same property in parameter info width parameter claim ");
		}*/
		
		
		/*try{
			BeanUtils.copyProperties(claims, info);
			System.out.println(claims);
		}catch(Exception e){
			throw new RuntimeException(e);
		}*/
		
		//jwt使用的加密方式
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		Key signingKey = new SecretKeySpec(claim.getSercurityStr().getBytes(), signatureAlgorithm.getJcaName());	
		
		JwtBuilder builder = Jwts.builder()
				.setClaims(info)//设置附加信息-Map
				.setIssuedAt(new Date(claim.getIat()))//设置签发时间
				.setExpiration(new Date(claim.getExpire()))//设置有效期时间 -- 此处注意,设置有效期必须在setClaims后执行,否则不起作用!!!
                .setIssuer(claim.getIss())//设置签发者
                .setAudience(claim.getAud())//设置被签发者
                .setSubject(claim.getSub())//json数据
                .signWith(signatureAlgorithm, signingKey);//加密秘钥
		//builder.setExpiration(new Date(claim.getExpire()));
		
		
		
		System.out.println("[" + MyJwtUtils.class.getName() + "] token期限：" + MyDateUtils.toString(new Date(claim.getExpire()), "yyyy-MM-dd hh:mm:ss"));
		
		String jwt = builder.compact();
		return jwt;
	}
	
	
	public static Claims parse(JwtClaims claim,String jwt) throws Exception{
		//Verify JWT (HS256)
		try {
			/* 验证秘钥、被签发者、签发者
			 * 第一个参数是密码 
			 * 第二个参数对应的是claims.put("aud", "audddd");
			 * 第三个参数对应的是claims.put("iss", issuer);
			 */
			
		    JWTVerifier verifier = new JWTVerifier(claim.getSercurityStr(),claim.getAud(),claim.getIss());
		    Map<String,Object> resMap = verifier.verify(jwt);
		    
		    Claims claims = Jwts.parser()        
		 		   .setSigningKey(claim.getSercurityStr().getBytes())
		 		   .parseClaimsJws(jwt).getBody();
		 		return claims;
		
		} catch(Exception e){
			throw e;
		}
	}
}
