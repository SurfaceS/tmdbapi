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
package net.ums.tmdbapi.endpoint.list;

import net.ums.tmdbapi.TMDbClient;
import net.ums.tmdbapi.endpoint.Endpoint;
import net.ums.tmdbapi.schema.list.ListStatusSchema;
import com.google.gson.JsonObject;

/**
 * List endpoint (V4).
 *
 * @author SurfaceS
 */
public class ListV3Endpoint extends Endpoint {

	private static final String V3_LIST_ENDPOINT = V4_ENDPOINT + "list";

	private final String name;
	private final String iso639Part1;
	private String description;
	private String iso3166Part1;
	private Boolean isPublic;
	private String sortBy;

	public ListV3Endpoint(TMDbClient tmdbClient, String name, String iso639Part1) {
		super(tmdbClient);
		this.iso639Part1 = iso639Part1;
		this.name = name;
	}

	/**
	 * Set the description.
	 *
	 * @param value description
	 * @return this endpoint
	 */
	public ListV3Endpoint setDescription(String value) {
		this.description = value;
		return this;
	}

	/**
	 * Set the ISO-3166-1 variant.
	 *
	 * @param value	ISO 3166-1 (country code)
	 * @return this endpoint
	 */
	public ListV3Endpoint setIso3166Part1(String value) {
		this.iso3166Part1 = value;
		return this;
	}

	/**
	 * Set the public status of your list.
	 *
	 * @param value	ISO 3166-1 (country code)
	 * @return this endpoint
	 */
	public ListV3Endpoint setPublic(Boolean value) {
		this.isPublic = value;
		return this;
	}

	/**
	 * Set sort option for the list.
	 *
	 * @param value name
	 * @return this endpoint
	 */
	public ListV3Endpoint setSortBy(ListSortBy value) {
		this.sortBy = value != null ? value.toString() : null;
		return this;
	}

	/**
	 * Create a new list. You will need to have valid user access token in order
	 * to create a new list.
	 *
	 * @return ListStatusSchema.
	 */
	public ListStatusSchema create() {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("name", name);
		jsonObject.addProperty("iso_639_1", iso639Part1);
		addPostString(jsonObject, "description", description);
		addPostString(jsonObject, "iso_3166_1", iso3166Part1);
		addPostBoolean(jsonObject, "public", isPublic, true);
		addPostString(jsonObject, "sort_by", sortBy);
		return tmdbClient.post(V3_LIST_ENDPOINT, ListStatusSchema.class, null, jsonObject.toString());
	}

}
