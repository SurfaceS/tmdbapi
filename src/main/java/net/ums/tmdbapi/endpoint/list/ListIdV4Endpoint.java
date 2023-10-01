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
import net.ums.tmdbapi.schema.StatusSchema;
import net.ums.tmdbapi.schema.list.ListV4ClearStatusSchema;
import com.google.gson.JsonObject;

/**
 * List endpoint (V4).
 *
 * @author SurfaceS
 */
public class ListIdV4Endpoint extends Endpoint {

	private static final String V4_LIST_ENDPOINT = V4_ENDPOINT + "list/";
	private static final String LIST_CLEAR_ENDPOINT = "/clear";

	private final long listId;

	private String description;
	private String iso3166Part1;
	private String iso639Part1;
	private Boolean isPublic;
	private String name;
	private int page;
	private String sortBy;

	public ListIdV4Endpoint(TMDbClient tmdbClient, long listId) {
		super(tmdbClient);
		this.listId = listId;
	}

	/**
	 * Set the description.
	 *
	 * @param value description
	 * @return this endpoint
	 */
	public ListIdV4Endpoint setDescription(String value) {
		this.description = value;
		return this;
	}

	/**
	 * Set the ISO-3166-1 variant.
	 *
	 * @param value	ISO 3166-1 (country code)
	 * @return this endpoint
	 */
	public ListIdV4Endpoint setIso3166Part1(String value) {
		this.iso3166Part1 = value;
		return this;
	}

	/**
	 * Set the ISO-639-1 variant.
	 *
	 * @param value	ISO 639-1 (language code)
	 * @return this endpoint
	 */
	public ListIdV4Endpoint setIso639Part1(String value) {
		this.iso639Part1 = value;
		return this;
	}

	/**
	 * Set the name.
	 *
	 * @param value name
	 * @return this endpoint
	 */
	public ListIdV4Endpoint setName(String value) {
		this.name = value;
		return this;
	}

	/**
	 * Set sort option for the list.
	 *
	 * @param value name
	 * @return this endpoint
	 */
	public ListIdV4Endpoint setSortBy(ListSortBy value) {
		this.sortBy = value != null ? value.toString() : null;
		return this;
	}

	/**
	 * Specify which page to query.
	 *
	 * @param value page number
	 * @return this endpoint
	 */
	public ListIdV4Endpoint setPage(int value) {
		this.page = value;
		return this;
	}

	/**
	 * Set the public status of your list.
	 *
	 * @param value	ISO 3166-1 (country code)
	 * @return this endpoint
	 */
	public ListIdV4Endpoint setPublic(Boolean value) {
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
	public ListV4ClearStatusSchema clear() {
		return tmdbClient.get(V4_LIST_ENDPOINT + listId + LIST_CLEAR_ENDPOINT, ListV4ClearStatusSchema.class, null);
	}

	/**
	 * This method will delete a list. This action is not reversible so take
	 * care when issuing it. You must be the owner of the list and therefore
	 * have a valid user access token in order to delete it.
	 *
	 * @return StatusSchema.
	 */
	public StatusSchema delete() {
		return tmdbClient.delete(V4_LIST_ENDPOINT + listId, StatusSchema.class, null);
	}

	/**
	 * This method will let you update the details of a list. You must be the
	 * owner of the list and therefore have a valid user access token in order
	 * to edit it.
	 *
	 * @return StatusSchema.
	 */
	public StatusSchema update() {
		JsonObject jsonObject = new JsonObject();
		addPostString(jsonObject, "description", description);
		addPostString(jsonObject, "iso_3166_1", iso3166Part1);
		addPostString(jsonObject, "iso_639_1", iso639Part1);
		addPostString(jsonObject, "name", name);
		addPostBoolean(jsonObject, "public", isPublic, true);
		addPostString(jsonObject, "sort_by", sortBy);
		return tmdbClient.put(V4_LIST_ENDPOINT + listId, StatusSchema.class, null, jsonObject.toString());
	}

}
