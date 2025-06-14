package com.jacreator.disease_form.views.afp;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;

public class FinalClassificationView extends VerticalLayout {
  public FinalClassificationView() {
    FormLayout form = new FormLayout();

    ComboBox<String> finalClassification = new ComboBox<>("Final Classification of Case");
    finalClassification.setItems("Lab confirmed", "Epidemiologically linked", "Clinically compatible", "Discarded",
        "Pending classification");

    RadioButtonGroup<String> polioType = new RadioButtonGroup<>();
    polioType.setLabel("Polio Type");
    polioType.setItems("cVPV", "aVPV", "iVPV");

    RadioButtonGroup<String> serotype = new RadioButtonGroup<>();
    serotype.setLabel("Indicate serotype");
    serotype.setItems("1", "2", "3");
    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2),
        new FormLayout.ResponsiveStep("700px", 3));
    form.add(finalClassification, polioType, serotype);

    // AccordionPanel panel = accordion.add("Final Classification", form);
    add(form);
  }
}
