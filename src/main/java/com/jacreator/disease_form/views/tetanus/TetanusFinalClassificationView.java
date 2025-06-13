package com.jacreator.disease_form.views.tetanus;

import java.time.LocalDate;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class TetanusFinalClassificationView extends VerticalLayout {
public TetanusFinalClassificationView() {
        setWidthFull();
        
        add(buildForm());
    }

    private FormLayout buildForm() {
        FormLayout form = new FormLayout();

        // Date sample collected
        DatePicker dateSampleCollected = new DatePicker("Date sample collected");
        dateSampleCollected.setMax(LocalDate.now());
        dateSampleCollected.setRequired(true);

        form.setResponsiveSteps(
            new FormLayout.ResponsiveStep("0", 1),
            new FormLayout.ResponsiveStep("600px", 2)
        );
        form.add(dateSampleCollected);

        return form;
    }
}
