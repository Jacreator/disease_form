package com.jacreator.disease_form.views.cholera;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;

public class CholeraEpidemiologicalView extends VerticalLayout {
public CholeraEpidemiologicalView() {
        setWidthFull();
        add(buildForm());
    }

    private FormLayout buildForm() {
        FormLayout form = new FormLayout();

        // Exposure details known
        RadioButtonGroup<String> exposureDetails = new RadioButtonGroup<>();
        exposureDetails.setLabel("Exposure details known");
        exposureDetails.setItems("Yes", "No", "Unknown");
        exposureDetails.setRequired(true);

        // Activity details
        RadioButtonGroup<String> activityDetails = new RadioButtonGroup<>();
        activityDetails.setLabel("Activity details");
        activityDetails.setItems("Yes", "No", "Unknown");
        activityDetails.setRequired(true);

        // Living or working in an area with high risk of transmission
        RadioButtonGroup<String> livingOrWorkingInHighRiskEnvironment = new RadioButtonGroup<>();
        livingOrWorkingInHighRiskEnvironment.setLabel("Living or working in an area with high risk of transmission");
        livingOrWorkingInHighRiskEnvironment.setItems("Yes", "No", "Unknown");
        livingOrWorkingInHighRiskEnvironment.setRequired(true);

        // Residing or traveled to areas with high risk
        RadioButtonGroup<String> areasWithHighRisk = new RadioButtonGroup<>();
        areasWithHighRisk.setLabel("Residing or traveled to areas with high risk");
        areasWithHighRisk.setItems("Yes", "No", "Unknown");
        areasWithHighRisk.setRequired(true);

        // Contact with source case known
        RadioButtonGroup<String> contactWithSourceCase = new RadioButtonGroup<>();
        contactWithSourceCase.setLabel("Contact with source case known");
        contactWithSourceCase.setItems("Yes", "No", "Unknown");
        contactWithSourceCase.setRequired(true);

        // Add all fields to the form
        form.add(exposureDetails, activityDetails);
        form.add(livingOrWorkingInHighRiskEnvironment, areasWithHighRisk);
        form.add(contactWithSourceCase);

        return form;
    }
}
