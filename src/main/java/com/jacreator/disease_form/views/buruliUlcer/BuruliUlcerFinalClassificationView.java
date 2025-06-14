package com.jacreator.disease_form.views.buruliUlcer;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class BuruliUlcerFinalClassificationView extends VerticalLayout {
public BuruliUlcerFinalClassificationView() {
        setWidthFull();
        add(buildForm());
    }

    private FormLayout buildForm() {
        FormLayout form = new FormLayout();

        // Healed
        RadioButtonGroup<String> healed = new RadioButtonGroup<>();
        healed.setLabel("Healed");
        healed.setItems("With sequelae", "With out sequelae");
        healed.setRequired(true);

        // Specify
        TextField specifySequelae = new TextField("Specify");
        specifySequelae.setPlaceholder("Specify sequelae");

        // Absconded Against Medical Advice
        RadioButtonGroup<String> absconded = new RadioButtonGroup<>();
        absconded.setLabel("Absconded Against Medical Advice");
        absconded.setItems("Yes", "No");
        absconded.setRequired(true);

        // Dead Or Alive
        RadioButtonGroup<String> deadOrAlive = new RadioButtonGroup<>();
        deadOrAlive.setLabel("Dead Or Alive");
        deadOrAlive.setItems("Yes", "No");
        deadOrAlive.setRequired(true);

        // If Dead, Buruli Ulcer Related?
        RadioButtonGroup<String> deathRelated = new RadioButtonGroup<>();
        deathRelated.setLabel("If Dead, Buruli Ulcer Related?");
        deathRelated.setItems("Yes", "No");
        deathRelated.setRequired(true);

        form.setResponsiveSteps(
            new FormLayout.ResponsiveStep("0", 1),
            new FormLayout.ResponsiveStep("600px", 2),
            new FormLayout.ResponsiveStep("700px", 3));
        // Add all fields to the form
        form.add(healed, specifySequelae);
        form.add(absconded, deadOrAlive);
        form.add(deathRelated);

        return form;
    }
}
