/*
 * Copyright (C) 2024 Universal Media Server
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.universalmediaserver.tmdbapi;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TMBd rate limit is 50 requests per second and 20 connections per IP.
 * @author SurfaceS
 */
public class TMDbRateLimiter {

	private static final AtomicInteger REQUEST_ID = new AtomicInteger();
	private static final ConcurrentHashMap<Integer, Long> REQUESTS = new ConcurrentHashMap<>();
	private static final int REQUEST_LIMIT = 50;
	private static final int REQUEST_LIMIT_MILLIS = 1000;
	private static final int REQUEST_LIMIT_WAIT_MILLIS = REQUEST_LIMIT_MILLIS / REQUEST_LIMIT;

	// This class is not instantiable
	private TMDbRateLimiter() {
	}

	public static int getRequestId() throws InterruptedException {
		final int id = REQUEST_ID.getAndIncrement();
		while (!hasRequestLimitWindow(id)) {
			Thread.sleep(REQUEST_LIMIT_WAIT_MILLIS);
		}
		return id;
	}

	public static synchronized void setRequestEnd(int id) {
		REQUESTS.put(id, System.currentTimeMillis());
	}

	private static synchronized boolean hasRequestLimitWindow(int id) {
		long now = System.currentTimeMillis();
		for (Iterator<Entry<Integer, Long>> iter = REQUESTS.entrySet().iterator(); iter.hasNext();) {
			Entry<Integer, Long> entry = iter.next();
			if (entry.getValue() + REQUEST_LIMIT_MILLIS < now) {
				iter.remove();
			}
		}
		if (REQUESTS.size() < REQUEST_LIMIT) {
			REQUESTS.put(id, System.currentTimeMillis());
			return true;
		} else {
			return false;
		}
	}

}
