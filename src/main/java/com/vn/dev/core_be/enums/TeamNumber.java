package com.vn.dev.core_be.enums;

import lombok.Getter;

// Enum Singleton
@Getter
public enum TeamNumber implements  TeamNumberInfo {

    SO ("System Operation (SO)"),
    BM("Buisness Management (BM)");

    private final String keyword;

    TeamNumber(String keyword1) {
        this.keyword = keyword1;
    }

    @Override
    public String getTeamName(String k){
        return TeamNumber.valueOf(k).keyword;

    }
}
