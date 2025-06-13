package com.jacreator.disease_form.views.guinea_worm;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class GuineaWormEpidemiologicalView extends VerticalLayout {
public GuineaWormEpidemiologicalView() {
        setWidthFull();
        add(buildForm());
    }

    private FormLayout buildForm() {
        FormLayout form = new FormLayout();

        // Have you had close contact with suspected or confirmed case?
        RadioButtonGroup<String> closeContact = new RadioButtonGroup<>();
        closeContact.setLabel("Have you had close contact with suspected or confirmed case?");
        closeContact.setItems("Yes", "No", "Unknown");
        closeContact.setRequired(true);

        // Travel history in the last 10-14 months
        TextField travelHistory = new TextField("Travel history in the last 10-14 months");
        travelHistory.setPlaceholder("Enter Travel history");

        // Place stayed in the last 10-14 months if not same as above
        RadioButtonGroup<String> placeStayed = new RadioButtonGroup<>();
        placeStayed.setLabel("Place stayed in the last 10-14 months if not same as above");
        placeStayed.setItems("Yes", "No", "Unknown");
        placeStayed.setRequired(true);

        // Associated with an outbreak
        RadioButtonGroup<String> associatedWithOutbreak = new RadioButtonGroup<>();
        associatedWithOutbreak.setLabel("Associated with an outbreak");
        associatedWithOutbreak.setItems("Yes", "No", "Unknown");
        associatedWithOutbreak.setRequired(true);

        // Responsive steps
        form.setResponsiveSteps(
            new FormLayout.ResponsiveStep("0", 1),
            new FormLayout.ResponsiveStep("800px", 2)
        );

        // Add all fields to the form
        form.add(
            closeContact,
            travelHistory,
            placeStayed,
            associatedWithOutbreak
        );

        return form;
    }
}
