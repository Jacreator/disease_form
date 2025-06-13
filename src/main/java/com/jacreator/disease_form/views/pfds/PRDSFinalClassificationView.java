package com.jacreator.disease_form.views.pfds;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;

public class PRDSFinalClassificationView extends VerticalLayout {

  public PRDSFinalClassificationView() {
    setWidthFull();

    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();

    // Final classification radio group
    RadioButtonGroup<String> finalClassification = new RadioButtonGroup<>();
    finalClassification.setLabel("Final classification");
    finalClassification.setItems("Confirmed", "Not a Case", "Probable", "Pending");
    finalClassification.setRequired(true);

    form.add(finalClassification);

    return form;
  }
}
