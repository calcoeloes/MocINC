package com.example.android.mocinc.response;

/**
 * Created by Khalil Qibran on 5/4/2017.
 */

import com.example.android.mocinc.model.Ticket;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TicketResponse {
    @SerializedName("page") private int page;
    @SerializedName("results") private List<Ticket> results;
    @SerializedName("total_results") private int totalResults;
    @SerializedName("total_pages") private int totalPages;

    public int getPage() { return page; }
    public void setPage(int page) { this.page = page; }
    public List<Ticket> getResults() { return results; }
    public void setResults(List<Ticket> results) { this.results = results; }
    public int getTotalResults() { return totalResults; }
    public void setTotalResults(int totalResults) { this.totalResults = totalResults; }
    public int getTotalPages() { return totalPages; }
    public void setTotalPages(int totalPages) { this.totalPages = totalPages; }
}

