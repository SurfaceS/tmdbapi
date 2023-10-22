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
package com.universalmediaserver.tmdbapi.schema;

import com.google.gson.annotations.SerializedName;

/**
 * TMDb Paged Results Schema.
 *
 * @author SurfaceS
 */
public class PagedResultsSchema {

	@SerializedName("page")
	private Long page;
	@SerializedName("total_results")
	private Long totalResults;
	@SerializedName("total_pages")
	private Long totalPages;

	public Long getPage() {
		return page;
	}

	public Long getTotalResults() {
		return totalResults;
	}

	public Long getTotalPages() {
		return totalPages;
	}

	public void setPage(Long value) {
		this.page = value;
	}

	public void setTotalResults(Long value) {
		this.totalResults = value;
	}

	public void setTotalPages(Long value) {
		this.totalPages = value;
	}

}
