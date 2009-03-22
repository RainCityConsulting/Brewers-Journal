package com.rcc.brew.search;

import com.rcc.brew.bean.Grain;
import com.rcc.brew.bean.Mfg;

import com.rcc.search.AbstractIdentifiableDocumentFactory;
import com.rcc.search.Utils;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;

public class GrainDocumentFactory extends AbstractIdentifiableDocumentFactory<Grain> {
    protected void finishDocument(Document doc, Grain g) {
        if (g.hasName()) {
            Utils.addField(doc, g, "name", Field.Store.YES, Field.Index.TOKENIZED);
        }

        if (g.hasMfg()) {
            if (g.getMfg().hasName()) {
                Utils.addField(doc, g, "mfg.name", Field.Store.YES, Field.Index.TOKENIZED);
            }
        }
    }

    protected Grain getObject(Document doc, int id) {
        Grain g = new Grain();
        g.setId(id);

        Utils.setStringProperty(doc, g, "name");

        if (doc.getField("mfg.name") != null) {
            g.setMfg(new Mfg());
            Utils.setStringProperty(doc, g, "mfg.name");
        }

        return g;
    }
}
