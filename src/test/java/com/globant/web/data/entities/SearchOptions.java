package com.globant.web.data.entities;

import lombok.*;

import java.time.LocalDate;

/**
 * Class to represent the search options
 *
 * @author Sebastian Mesa
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SearchOptions {
    private String urlBacklog;
    private String urlNewDash;
    private String urlQuery;
    private String nameBacklog;
    private String nameNewDash;
    private String nameQuery;
}
