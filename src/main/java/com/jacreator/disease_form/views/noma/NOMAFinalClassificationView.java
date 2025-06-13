package com.jacreator.disease_form.views.noma;

import java.util.Arrays;
import java.util.List;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;

public class NOMAFinalClassificationView extends VerticalLayout {
  public NOMAFinalClassificationView() {
    setWidthFull();
    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();

    // Final classification options
    List<String> finalClassificationOptions = Arrays.asList("Epidemiological Link", "Discarded");
    RadioButtonGroup<String> finalClassification = new RadioButtonGroup<>();
    finalClassification.setLabel("Final classification");
    finalClassification.setItems(finalClassificationOptions);
    finalClassification.setRequired(true);

    // Responsive steps
    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("800px", 2));

    // Add field to the form
    form.add(finalClassification);

    return form;
  }
}
