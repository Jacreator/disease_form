package com.jacreator.disease_form.views.diphtheria;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class ComplicationsView extends VerticalLayout {
private RadioButtonGroup<String> neurologicalDeficits;
    private RadioButtonGroup<String> bleedingDisorder;
    private RadioButtonGroup<String> renalImpairment;
    private RadioButtonGroup<String> cardiacComplications;
    private RadioButtonGroup<String> hadTracheostomy;
    private TextField otherSymptoms;

    public ComplicationsView() {
        setWidthFull();
        setPadding(true);
        setSpacing(true);

        add(buildForm());
    }

    private FormLayout buildForm() {
        FormLayout form = new FormLayout();
        form.setWidthFull();
        form.setResponsiveSteps(
            new FormLayout.ResponsiveStep("0", 1),
            new FormLayout.ResponsiveStep("600px", 2),
            new FormLayout.ResponsiveStep("900px", 3)
        );

        neurologicalDeficits = new RadioButtonGroup<>("Neurological deficits");
        neurologicalDeficits.setItems("yes", "no");
        neurologicalDeficits.setRequired(true);
        neurologicalDeficits.setRequiredIndicatorVisible(true);

        bleedingDisorder = new RadioButtonGroup<>("Bleeding disorder");
        bleedingDisorder.setItems("yes", "no");
        bleedingDisorder.setRequired(true);
        bleedingDisorder.setRequiredIndicatorVisible(true);

        renalImpairment = new RadioButtonGroup<>("Renal impairment");
        renalImpairment.setItems("yes", "no");
        renalImpairment.setRequired(true);
        renalImpairment.setRequiredIndicatorVisible(true);

        cardiacComplications = new RadioButtonGroup<>("Cardiac complications");
        cardiacComplications.setItems("yes", "no");
        cardiacComplications.setRequired(true);
        cardiacComplications.setRequiredIndicatorVisible(true);

        hadTracheostomy = new RadioButtonGroup<>("Had tracheostomy");
        hadTracheostomy.setItems("yes", "no");
        hadTracheostomy.setRequired(true);
        hadTracheostomy.setRequiredIndicatorVisible(true);

        otherSymptoms = new TextField("Other symptoms");
        otherSymptoms.setRequired(true);
        otherSymptoms.setRequiredIndicatorVisible(true);

        form.add(
            neurologicalDeficits,
            bleedingDisorder,
            renalImpairment,
            cardiacComplications,
            hadTracheostomy,
            otherSymptoms
        );

        return form;
    }
}
