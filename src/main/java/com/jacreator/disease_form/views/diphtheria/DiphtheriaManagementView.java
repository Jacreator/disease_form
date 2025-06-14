package com.jacreator.disease_form.views.diphtheria;

import java.time.LocalDate;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;

public class DiphtheriaManagementView extends VerticalLayout {
private RadioButtonGroup<String> datAdministered;
    private RadioButtonGroup<String> coMorbidities;
    private RadioButtonGroup<String> antibioticsAdministered;
    private RadioButtonGroup<String> contactToPersonWithSimilarIllness;
    private RadioButtonGroup<String> outcome;
    private DatePicker dateOfOutcome;

    public DiphtheriaManagementView() {
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
            new FormLayout.ResponsiveStep("700px", 3));

        datAdministered = new RadioButtonGroup<>("DAT administered?");
        datAdministered.setItems("yes", "no");
        datAdministered.setRequired(true);
        datAdministered.setRequiredIndicatorVisible(true);

        coMorbidities = new RadioButtonGroup<>("Co-morbidities?");
        coMorbidities.setItems("yes", "no");
        coMorbidities.setRequired(true);
        coMorbidities.setRequiredIndicatorVisible(true);

        antibioticsAdministered = new RadioButtonGroup<>("Antibiotics administered?");
        antibioticsAdministered.setItems("yes", "no");
        antibioticsAdministered.setRequired(true);
        antibioticsAdministered.setRequiredIndicatorVisible(true);

        contactToPersonWithSimilarIllness = new RadioButtonGroup<>("Contact to person with similar illness?");
        contactToPersonWithSimilarIllness.setItems("yes", "no");
        contactToPersonWithSimilarIllness.setRequired(true);
        contactToPersonWithSimilarIllness.setRequiredIndicatorVisible(true);

        outcome = new RadioButtonGroup<>("Outcome");
        outcome.setItems("yes", "no");
        outcome.setRequired(true);
        outcome.setRequiredIndicatorVisible(true);

        dateOfOutcome = new DatePicker("Date of outcome");
        dateOfOutcome.setRequired(true);
        dateOfOutcome.setRequiredIndicatorVisible(true);
        dateOfOutcome.setMax(LocalDate.now());

        form.add(
            datAdministered,
            coMorbidities,
            antibioticsAdministered,
            contactToPersonWithSimilarIllness,
            outcome,
            dateOfOutcome
        );

        return form;
    }
}
