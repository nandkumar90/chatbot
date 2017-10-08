package com.journaldev.spring.model;

import java.util.List;

public class Translationresponse {


private Integer wordCount;

private List<Translation> translations = null;

private Integer characterCount;

public Integer getWordCount() {
return wordCount;
}

public void setWordCount(Integer wordCount) {
this.wordCount = wordCount;
}

public List<Translation> getTranslations() {
return translations;
}

public void setTranslations(List<Translation> translations) {
this.translations = translations;
}

public Integer getCharacterCount() {
return characterCount;
}

public void setCharacterCount(Integer characterCount) {
this.characterCount = characterCount;
}

}
