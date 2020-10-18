package com.myntra.anotation;

public enum TesterName {
    ABHIJEET("Singh Abhijeet");

    public String authorName;
    TesterName(String authorName)
    {
        this.authorName=authorName;
    }

    public String toString() {
        return this.authorName;
    }
}
