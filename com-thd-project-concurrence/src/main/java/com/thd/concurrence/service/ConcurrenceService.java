package com.thd.concurrence.service;

public interface ConcurrenceService {
	public int xlock(int id);
	public int optimisticLock(int id);
	public long addForRedis();
	public void clearRedis();
}
