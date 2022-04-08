package com.napier.sem;

public class Language {
    private String language;
    private float popper;
    private Long worldpop;

    public Long getWorldpop() {
        return worldpop;
    }

    public void setWorldpop(Long worldpop) {
        this.worldpop = worldpop;
    }

    public float getPopper() {
        return popper;
    }

    public void setPopper(float popper) {
        this.popper = popper;
    }

    public Language(String language, float popper) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }


}
