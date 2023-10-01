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
package net.ums.tmdbapi.schema.list;

import net.ums.tmdbapi.schema.IntegerIdNameSchema;
import com.google.gson.annotations.SerializedName;

/**
 * TMDb List V3 Simple Schema.
 *
 * @author SurfaceS
 */
public class ListV3SimpleSchema extends IntegerIdNameSchema {

	@SerializedName("description")
	private String description;
	@SerializedName("favorite_count")
	private Long favoriteCount;
	@SerializedName("item_count")
	private Long itemCount;
	@SerializedName("iso_639_1")
	private String iso639Part1;
	@SerializedName("list_type")
	private String listType;

	public String getDescription() {
		return description;
	}

	public Long getFavoriteCount() {
		return favoriteCount;
	}

	public Long getItemCount() {
		return itemCount;
	}

	public String getIso639Part1() {
		return iso639Part1;
	}

	public String getListType() {
		return listType;
	}

	public void setDescription(String value) {
		this.description = value;
	}

	public void setFavoriteCount(Long value) {
		this.favoriteCount = value;
	}

	public void setItemCount(Long value) {
		this.itemCount = value;
	}

	public void setIso639Part1(String value) {
		this.iso639Part1 = value;
	}

	public void setListType(String value) {
		this.listType = value;
	}

}
