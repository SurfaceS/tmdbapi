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
package com.universalmediaserver.tmdbapi.endpoint.list;

import com.google.gson.JsonObject;
import com.universalmediaserver.tmdbapi.TMDbClient;
import com.universalmediaserver.tmdbapi.endpoint.Endpoint;
import com.universalmediaserver.tmdbapi.schema.StatusSchema;
import com.universalmediaserver.tmdbapi.schema.list.ListClearStatusSchema;
import java.util.HashMap;
import java.util.Map;

/**
 * List endpoint (V3).
 *
 * @author SurfaceS
 */
public class ListIdV3Endpoint extends Endpoint {

	private static final String V3_LIST_ENDPOINT = V3_ENDPOINT + "list/";
	private static final String LIST_CLEAR_ENDPOINT = "/clear";

	private final long listId;

	private String description;
	private String iso3166Part1;
	private String iso639Part1;
	private Boolean isPublic;
	private String name;
	private Boolean confirm;
	private String sortBy;

	public ListIdV3Endpoint(TMDbClient tmdbClient, long listId) {
		super(tmdbClient);
		this.listId = listId;
	}

	/**
	 * Set the description.
	 *
	 * @param value description
	 * @return this endpoint
	 */
	public ListIdV3Endpoint setDescription(String value) {
		this.description = value;
		return this;
	}

	/**
	 * Set the ISO-3166-1 variant.
	 *
	 * @param value	ISO 3166-1 (country code)
	 * @return this endpoint
	 */
	public ListIdV3Endpoint setIso3166Part1(String value) {
		this.iso3166Part1 = value;
		return this;
	}

	/**
	 * Set the ISO-639-1 variant.
	 *
	 * @param value	ISO 639-1 (language code)
	 * @return this endpoint
	 */
	public ListIdV3Endpoint setIso639Part1(String value) {
		this.iso639Part1 = value;
		return this;
	}

	/**
	 * Set the name.
	 *
	 * @param value name
	 * @return this endpoint
	 */
	public ListIdV3Endpoint setName(String value) {
		this.name = value;
		return this;
	}

	/**
	 * Set sort option for the list.
	 *
	 * @param value name
	 * @return this endpoint
	 */
	public ListIdV3Endpoint setSortBy(ListSortBy value) {
		this.sortBy = value != null ? value.toString() : null;
		return this;
	}

	/**
	 * Specify which page to query.
	 *
	 * @param value page number
	 * @return this endpoint
	 */
	public ListIdV3Endpoint setPage(boolean value) {
		this.confirm = value;
		return this;
	}

	/**
	 * Set the public status of your list.
	 *
	 * @param value	ISO 3166-1 (country code)
	 * @return this endpoint
	 */
	public ListIdV3Endpoint setPublic(Boolean value) {
		this.isPublic = value;
		return this;
	}

	/**
	 * This method lets you clear all of the items from a list in a single
	 * request. This action is not reversible so take care when issuing it. You
	 * must be the owner of the list and therefore have a valid user access
	 * token in order to clear it.
	 *
	 * @return StatusSchema.
	 */
	public ListClearStatusSchema clear() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_SESSION_ID, tmdbClient.getSessionId());
		addQueryBoolean(query, QUERY_CONFIRM, confirm);
		return tmdbClient.get(V3_LIST_ENDPOINT + listId + LIST_CLEAR_ENDPOINT, ListClearStatusSchema.class, query);
	}

	/**
	 * This method will delete a list. This action is not reversible so take
	 * care when issuing it. You must be the owner of the list and therefore
	 * have a valid user access token in order to delete it.
	 *
	 * @return StatusSchema.
	 */
	public StatusSchema delete() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_SESSION_ID, tmdbClient.getSessionId());
		return tmdbClient.delete(V3_LIST_ENDPOINT + listId, StatusSchema.class, query);
	}

	/**
	 * This method will let you update the details of a list. You must be the
	 * owner of the list and therefore have a valid user access token in order
	 * to edit it.
	 *
	 * @return StatusSchema.
	 */
	public StatusSchema update() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_SESSION_ID, tmdbClient.getSessionId());
		JsonObject jsonObject = new JsonObject();
		addPostString(jsonObject, "description", description);
		addPostString(jsonObject, "iso_3166_1", iso3166Part1);
		addPostString(jsonObject, "iso_639_1", iso639Part1);
		addPostString(jsonObject, "name", name);
		addPostBoolean(jsonObject, "public", isPublic, true);
		addPostString(jsonObject, "sort_by", sortBy);
		return tmdbClient.put(V3_LIST_ENDPOINT + listId, StatusSchema.class, query, jsonObject.toString());
	}

}
