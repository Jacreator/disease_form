package com.jacreator.disease_form.views.dengue;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class DengueContactTracingView extends VerticalLayout {
  private static final List<String> STATE_DATA = Arrays.asList("FCT", "Enugu");
  private static final Map<String, List<String>> LGA_DATA = new HashMap<>() {
    {
      put("FCT", Arrays.asList("AMAC", "Bwari", "Kwali"));
      put("Enugu", Arrays.asList("Nsukka", "Enugu south", "Udi"));
    }
  };

  private ComboBox<String> stateCombo;
  private ComboBox<String> lgaCombo;

  public DengueContactTracingView() {
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
        new FormLayout.ResponsiveStep("600px", 2));

    stateCombo = new ComboBox<>("State");
    stateCombo.setItems(STATE_DATA);
    stateCombo.setRequired(true);
    stateCombo.setRequiredIndicatorVisible(true);

    lgaCombo = new ComboBox<>("LGA");
    lgaCombo.setRequired(true);
    lgaCombo.setRequiredIndicatorVisible(true);

    stateCombo.addValueChangeListener(e -> {
      String selectedState = e.getValue();
      if (selectedState != null) {
        lgaCombo.setItems(LGA_DATA.getOrDefault(selectedState, Collections.emptyList()));
        lgaCombo.clear();
      } else {
        lgaCombo.clear();
        lgaCombo.setItems(Collections.emptyList());
      }
    });

    form.add(stateCombo, lgaCombo);

    return form;
  }
}
