package com.jacreator.disease_form.views.yew;

import java.util.Arrays;
import java.util.List;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class YewFinalClassificationView extends VerticalLayout {

private static final List<String> CLASSIFICATIONS = Arrays.asList(
            "Suspected Case", "Confirmed Case", "Not a Yaws Case"
    );

    public YewFinalClassificationView() {
        setWidthFull();
        
        add(buildForm());
    }

    private FormLayout buildForm() {
        FormLayout form = new FormLayout();

        // Final Classification
        ComboBox<String> finalClassification = new ComboBox<>("Final Classification");
        finalClassification.setItems(CLASSIFICATIONS);
        finalClassification.setPlaceholder("Select Option");
        finalClassification.setRequired(true);

        form.setResponsiveSteps(
            new FormLayout.ResponsiveStep("0", 1),
            new FormLayout.ResponsiveStep("600px", 2),
            new FormLayout.ResponsiveStep("700px", 3));
        // Add field to the form
        form.add(finalClassification);

        return form;
    }
}
