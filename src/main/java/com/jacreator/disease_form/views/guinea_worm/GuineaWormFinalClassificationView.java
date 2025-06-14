package com.jacreator.disease_form.views.guinea_worm;

import java.util.Arrays;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class GuineaWormFinalClassificationView extends VerticalLayout{
public GuineaWormFinalClassificationView() {
        setWidthFull();
        add(buildForm());
    }

    private FormLayout buildForm() {
        FormLayout form = new FormLayout();

        // Final Classification dropdown
        ComboBox<String> finalClassification = new ComboBox<>("Select the final classification of this case");
        finalClassification.setItems(Arrays.asList(
            "Lab confirmed",
            "Epidemiologically Linked",
            "Clinically Compatible",
            "Discarded",
            "Pending Classification"
        ));
        finalClassification.setPlaceholder("Select Option");
        finalClassification.setClearButtonVisible(true);
        finalClassification.setRequired(true);

        // Responsive steps
        form.setResponsiveSteps(
            new FormLayout.ResponsiveStep("0", 1),
            new FormLayout.ResponsiveStep("600px", 2),
            new FormLayout.ResponsiveStep("700px", 3));

        // Add field to the form
        form.add(finalClassification);

        return form;
    }
}
