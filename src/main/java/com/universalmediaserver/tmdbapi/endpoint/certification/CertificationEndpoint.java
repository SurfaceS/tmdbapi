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
package com.universalmediaserver.tmdbapi.endpoint.certification;

import com.universalmediaserver.tmdbapi.TMDbClient;
import com.universalmediaserver.tmdbapi.endpoint.Endpoint;
import com.universalmediaserver.tmdbapi.schema.certification.CertificationsSchema;

/**
 * Certification endpoint.
 *
 * @author SurfaceS
 */
public class CertificationEndpoint extends Endpoint {

	private static final String V3_CERTIFICATION_ENDPOINT = V3_ENDPOINT + "certification/";
	private static final String MOVIE_LIST_ENDPOINT = V3_CERTIFICATION_ENDPOINT + "movie/list";
	private static final String TV_LIST_ENDPOINT = V3_CERTIFICATION_ENDPOINT + "tv/list";

	public CertificationEndpoint(TMDbClient tmdbClient) {
		super(tmdbClient);
	}

	/**
	 * Get Movie Certifications. Get an up to date list of the officially
	 * supported movie certifications on TMDB.
	 *
	 * @return Movie Certifications.
	 */
	public CertificationsSchema getMovieList() {
		return tmdbClient.get(MOVIE_LIST_ENDPOINT, CertificationsSchema.class, null);
	}

	/**
	 * Get TV Certifications. Get an up to date list of the officially supported
	 * TV show certifications on TMDB.
	 *
	 * @return TV Certifications.
	 */
	public CertificationsSchema getTvList() {
		return tmdbClient.get(TV_LIST_ENDPOINT, CertificationsSchema.class, null);
	}

}
