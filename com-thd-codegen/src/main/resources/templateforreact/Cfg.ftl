------------------- 在src/index.js文件中添加如下内容:   

import ${cfg.tableCodeForClass}Model from './module/${cfg.nameSpace}/${cfg.tableCodeForProperty}/${cfg.tableCodeForClass}Model';

app.model(${cfg.tableCodeForClass}Model);



------------------- src/constant/sysVar.js

var REQUEST_URL = {
    ${cfg.tableCodeForUpper} : {
      QUERY : "/${cfg.nameSpace}/${cfg.urlActionName}/query",
      SAVE : "/${cfg.nameSpace}/${cfg.urlActionName}/",
      DELETE : "/${cfg.nameSpace}/${cfg.urlActionName}/",
      UPDATE : "/${cfg.nameSpace}/${cfg.urlActionName}/",
      GET : "/${cfg.nameSpace}/${cfg.urlActionName}/",
      DELETEBATCH : "/${cfg.nameSpace}/${cfg.urlActionName}/delete${cfg.tableCodeForClass}Batch/"
    },
}


------------------- src/components/index/Header.js

<Menu.Item key="${cfg.tableCodeForClass}">
	<Link to="/${cfg.nameSpace}/${cfg.tableCodeForClass}Router"><Icon type="user" />  ${cfg.tableName} </Link>
</Menu.Item>


------------------- src/routes/Index.js

import ${cfg.tableCodeForClass}Router from '../module/${cfg.nameSpace}/${cfg.tableCodeForProperty}/${cfg.tableCodeForClass}Router'
<Route exact path="/${cfg.nameSpace}/${cfg.tableCodeForClass}Router" component={${cfg.tableCodeForClass}Router} />

