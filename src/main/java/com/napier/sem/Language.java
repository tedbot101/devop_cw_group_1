package com.napier.sem;

public class Language {
    private String language;

    public Language(String language, int popper) {
        this.language = language;
        this.popper = popper;

    }



    private int popper;
    private Long worldpop;

    public Long getWorldpop() {
        return worldpop;
    }

    public void setWorldpop(Long worldpop) {
        this.worldpop = worldpop;
    }

    public int getPopper() {
        return popper;
    }

    public void setPopper(int popper) {
        this.popper = popper;
    }



    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }


}
