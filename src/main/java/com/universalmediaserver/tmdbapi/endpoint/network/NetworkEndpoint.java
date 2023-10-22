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
package com.universalmediaserver.tmdbapi.endpoint.network;

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
 * Network endpoint. Get network details.
 *
 * @author SurfaceS
 */
public class NetworkEndpoint extends Endpoint {

	private static final String V3_NETWORK_ENDPOINT = V3_ENDPOINT + "network/";
	private static final String IMAGES_ENDPOINT = "/images";
	private static final String ALTERNATIVE_NAMES_ENDPOINT = "/alternative_names";

	private final long networkId;
	private final List<NetworkAppendToResponse> appendToResponse = new ArrayList<>();

	public NetworkEndpoint(TMDbClient tmdbClient, long networkId) {
		super(tmdbClient);
		this.networkId = networkId;
	}

	public NetworkEndpoint appendToResponse(NetworkAppendToResponse... values) {
		if (values != null) {
			for (NetworkAppendToResponse networkAppendToResponse : values) {
				if (!appendToResponse.contains(networkAppendToResponse)) {
					appendToResponse.add(networkAppendToResponse);
				}
			}
		}
		return this;
	}

	/**
	 * Get network details.
	 *
	 * @return Network details.
	 */
	public NetworkDetailsSchema getDetails() {
		Map<String, String> query = new HashMap<>();
		addQueryEnums(query, QUERY_APPEND_TO_RESPONSE, appendToResponse);
		return tmdbClient.get(V3_NETWORK_ENDPOINT + networkId, NetworkDetailsSchema.class, query);
	}

	/**
	 * Get network images.
	 *
	 * @return Network images.
	 */
	public NetworkImagesResponseSchema getImages() {
		return tmdbClient.get(V3_NETWORK_ENDPOINT + networkId + IMAGES_ENDPOINT, NetworkImagesResponseSchema.class, null);
	}

	/**
	 * Get network alternative names.
	 *
	 * @return Network alternative names.
	 */
	public NetworkAlternativeNamesResponseSchema getAlternativeNames() {
		return tmdbClient.get(V3_NETWORK_ENDPOINT + networkId + ALTERNATIVE_NAMES_ENDPOINT, NetworkAlternativeNamesResponseSchema.class, null);
	}

}
