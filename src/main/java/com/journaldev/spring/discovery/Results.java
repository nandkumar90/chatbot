package com.journaldev.spring.discovery;

public class Results {
	private String id;

    private Enriched_text enriched_text;

    private Extracted_metadata extracted_metadata;

    private String text;

    private String score;

    private String html;

    private Highlight highlight;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public Enriched_text getEnriched_text ()
    {
        return enriched_text;
    }

    public void setEnriched_text (Enriched_text enriched_text)
    {
        this.enriched_text = enriched_text;
    }

    public Extracted_metadata getExtracted_metadata ()
    {
        return extracted_metadata;
    }

    public void setExtracted_metadata (Extracted_metadata extracted_metadata)
    {
        this.extracted_metadata = extracted_metadata;
    }

    public String getText ()
    {
        return text;
    }

    public void setText (String text)
    {
        this.text = text;
    }

    public String getScore ()
    {
        return score;
    }

    public void setScore (String score)
    {
        this.score = score;
    }

    public String getHtml ()
    {
        return html;
    }

    public void setHtml (String html)
    {
        this.html = html;
    }

    public Highlight getHighlight ()
    {
        return highlight;
    }

    public void setHighlight (Highlight highlight)
    {
        this.highlight = highlight;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", enriched_text = "+enriched_text+", extracted_metadata = "+extracted_metadata+", text = "+text+", score = "+score+", html = "+html+", highlight = "+highlight+"]";
    }
}
