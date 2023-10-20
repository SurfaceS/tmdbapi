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
package com.universalmediaserver.tmdbapi.endpoint.company;

import com.universalmediaserver.tmdbapi.TMDbClient;
import com.universalmediaserver.tmdbapi.endpoint.Endpoint;
import com.universalmediaserver.tmdbapi.schema.network.NetworkAlternativeNamesResponseSchema;
import com.universalmediaserver.tmdbapi.schema.network.NetworkDetailsSchema;
import com.universalmediaserver.tmdbapi.schema.network.NetworkImagesResponseSchema;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Company endpoint. Get company details.
 *
 * @author SurfaceS
 */
public class CompanyEndpoint extends Endpoint {

	private static final String V3_NETWORK_ENDPOINT = V3_ENDPOINT + "network/";
	private static final String IMAGES_ENDPOINT = "/images";
	private static final String ALTERNATIVE_NAMES_ENDPOINT = "/alternative_names";

	private final long networkId;
	private final List<CompanyAppendToResponse> appendToResponse = new ArrayList<>();

	public CompanyEndpoint(TMDbClient tmdbClient, long networkId) {
		super(tmdbClient);
		this.networkId = networkId;
	}

	public CompanyEndpoint appendToResponse(CompanyAppendToResponse... values) {
		if (values != null) {
			for (CompanyAppendToResponse value : values) {
				if (!appendToResponse.contains(value)) {
					appendToResponse.add(value);
				}
			}
		}
		return this;
	}

	/**
	 * Get company details.
	 *
	 * @return Company details.
	 */
	public NetworkDetailsSchema getDetails() {
		Map<String, String> query = new HashMap<>();
		addQueryEnums(query, QUERY_APPEND_TO_RESPONSE, appendToResponse);
		return tmdbClient.get(V3_NETWORK_ENDPOINT + networkId, NetworkDetailsSchema.class, query);
	}

	/**
	 * Get company images.
	 *
	 * @return Company images.
	 */
	public NetworkImagesResponseSchema getImages() {
		return tmdbClient.get(V3_NETWORK_ENDPOINT + networkId + IMAGES_ENDPOINT, NetworkImagesResponseSchema.class, null);
	}

	/**
	 * Get company alternative names.
	 *
	 * @return Company alternative names.
	 */
	public NetworkAlternativeNamesResponseSchema getAlternativeNames() {
		return tmdbClient.get(V3_NETWORK_ENDPOINT + networkId + ALTERNATIVE_NAMES_ENDPOINT, NetworkAlternativeNamesResponseSchema.class, null);
	}

}
