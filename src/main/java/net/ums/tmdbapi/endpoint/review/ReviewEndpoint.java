/*
 * Copyright (C) 2023 Universal Media Server
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
package net.ums.tmdbapi.endpoint.review;

import net.ums.tmdbapi.TMDbClient;
import net.ums.tmdbapi.endpoint.Endpoint;
import net.ums.tmdbapi.schema.reviews.ReviewSchema;

/**
 * Review endpoint.
 *
 * @author SurfaceS
 */
public class ReviewEndpoint extends Endpoint {

	private static final String V3_REVIEW_ENDPOINT = V3_ENDPOINT + "review/";

	private final String reviewId;

	public ReviewEndpoint(TMDbClient tmdbClient, String reviewId) {
		super(tmdbClient);
		this.reviewId = reviewId;
	}

	/**
	 * Retrieve the details of a movie or TV show review.
	 *
	 * @return review details
	 */
	public ReviewSchema getDetails() {
		return tmdbClient.get(V3_REVIEW_ENDPOINT + reviewId, ReviewSchema.class, null);
	}

}
