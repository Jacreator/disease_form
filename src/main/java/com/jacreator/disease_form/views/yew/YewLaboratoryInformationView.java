package com.jacreator.disease_form.views.yew;

import java.util.Arrays;
import java.util.List;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class YewLaboratoryInformationView extends VerticalLayout {
private static final List<String> SAMPLE = Arrays.asList(
            "Finger prick blood for Trep. POC",
            "Finger prick blood for DPP POC",
            "Swab/scraping from lesions for PCR"
    );
    private static final List<String> POC = Arrays.asList("Positive", "Negative", "Not done");
    private static final List<String> PCR = Arrays.asList("Positive", "Negative", "Not done");
    private static final List<String> DPP = Arrays.asList("Positive", "Negative", "Not done");
    private static final List<String> DUAL = Arrays.asList("Positive", "Negative", "Not done");

    public YewLaboratoryInformationView() {
        setWidthFull();
        
        add(buildForm());
    }

    private FormLayout buildForm() {
        FormLayout form = new FormLayout();

        // Sampling Methods
        ComboBox<String> specimenType = new ComboBox<>("Sampling Methods");
        specimenType.setItems(SAMPLE);
        specimenType.setPlaceholder("Select Option");
        specimenType.setRequired(true);

        // Treponemal POC Test
        ComboBox<String> pocTest = new ComboBox<>("Treponemal POC Test");
        pocTest.setItems(POC);
        pocTest.setPlaceholder("Select Option");
        pocTest.setRequired(true);

        // PCR Result
        ComboBox<String> pcrResult = new ComboBox<>("PCR Result");
        pcrResult.setItems(PCR);
        pcrResult.setPlaceholder("Select Option");
        pcrResult.setRequired(true);

        // DPP dual POC treponemal line/TPHA
        ComboBox<String> dppTreponemal = new ComboBox<>("DPP dual POC treponemal line/TPHA");
        dppTreponemal.setItems(DPP);
        dppTreponemal.setPlaceholder("Select Option");
        dppTreponemal.setRequired(true);

        // DPP dual POC non-treponemal line/RPR
        ComboBox<String> dppNonTreponemal = new ComboBox<>("DPP dual POC non-treponemal line/RPR");
        dppNonTreponemal.setItems(DUAL);
        dppNonTreponemal.setPlaceholder("Select Option");
        dppNonTreponemal.setRequired(true);

        // Add all fields to the form
        form.add(specimenType, pocTest, pcrResult, dppTreponemal, dppNonTreponemal);

        

        return form;
    }
}
