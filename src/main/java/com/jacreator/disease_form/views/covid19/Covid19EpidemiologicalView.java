package com.jacreator.disease_form.views.covid19;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class Covid19EpidemiologicalView extends VerticalLayout {
// Data
    private static final List<String> countryData = Arrays.asList("China", "United Kingdom", "USA", "India", "Ghana");
    private static final List<String> gatheringType = Arrays.asList("Burial", "Religious gathering", "Sport events", "Wedding", "Others");
    private static final List<String> stateData = Arrays.asList("FCT", "Enugu");
    private static final List<String> vaccineType = Arrays.asList("Ad26.COV2.S", "Novavax", "Oxford–AstraZeneca", "Pfizer–BioNTech", "Sanofi-GSK", "Unknown");
    private static final Map<String, List<String>> lgaData = new HashMap<>() {{
        put("FCT", Arrays.asList("AMAC", "Bwari", "Kwali"));
        put("Enugu", Arrays.asList("Nsukka", "Enugu south", "Udi"));
    }};
    private static final List<String[]> comorbidityOption = Arrays.asList(
            new String[]{"Hypertension", "hypertension"},
            new String[]{"Diabetes", "diabetes"},
            new String[]{"Respiratory diseases", "respiratory diseases"},
            new String[]{"Immunocompromised conditions", "immunocompromised conditions"},
            new String[]{"Obesity", "obesity"},
            new String[]{"Chronic kidney disease", "Chronic kidney disease"},
            new String[]{"Liver diseases", "Liver disease"},
            new String[]{"Neurological conditions", "Neurological conditions"}
    );

    // Fields
    private RadioButtonGroup<String> vaccinationStatus;
    private ComboBox<String> vaccineTypeCombo;
    private RadioButtonGroup<String> numberOfVaccineDoses;
    private DatePicker dateOfFirstVaccination;
    private DatePicker dateOfSecondVaccination;

    private RadioButtonGroup<String> returnedFromLocalTravel14Days;
    private DatePicker dateOfLocalTravelStart;
    private DatePicker dateOfTravelEndLocal;
    private ComboBox<String> stateOfTravel;
    private ComboBox<String> lgaOfTravel;
    private TextField clientTravelAddressLocal;

    private RadioButtonGroup<String> returnedFromInternationalTravel14Days;
    private DatePicker dateOfInternationalTravelStart;
    private DatePicker dateOfInternationalTravelEnd;
    private ComboBox<String> countryOfTravel;
    private ComboBox<String> cityOfTravel;
    private TextField clientTravelAddressInternational;

    private RadioButtonGroup<String> contactWithSuspectedConfirmedCase;
    private TextField epidOrNameOfCase;

    private RadioButtonGroup<String> attendedAnyEvent;
    private ComboBox<String> gatheringTypeCombo;
    private DatePicker startDateEvent;
    private DatePicker endDateEvent;
    private ComboBox<String> stateOfEvent;
    private ComboBox<String> lgaOfEvent;
    private TextField descriptionOfEvent;

    private RadioButtonGroup<String> visitedOrAdmittedInpatient;
    private DatePicker dateHospitalVisitOrAdmission;
    private TextField addressHospitalVisitedOrAdmitted;

    private RadioButtonGroup<String> visitOutpatient;
    private DatePicker dateHospitalVisit;
    private TextField addressHospitalVisited;

    private RadioButtonGroup<String> personOutcome;
    private DatePicker dateOfDeathOutcome;

    private final Map<String, RadioButtonGroup<String>> comorbidityGroups = new LinkedHashMap<>();

    public Covid19EpidemiologicalView() {
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

        // Vaccination
        vaccinationStatus = createRadioGroup("Vaccination status", true);
        vaccineTypeCombo = new ComboBox<>("Vaccine type");
        vaccineTypeCombo.setItems(vaccineType);
        vaccineTypeCombo.setVisible(false);
        numberOfVaccineDoses = createRadioGroup("Number of vaccine doses", true, "1", "2");
        numberOfVaccineDoses.setVisible(false);
        dateOfFirstVaccination = new DatePicker("Date of first vaccination");
        dateOfFirstVaccination.setMax(LocalDate.now());
        dateOfFirstVaccination.setVisible(false);
        dateOfSecondVaccination = new DatePicker("Date of second vaccination");
        dateOfSecondVaccination.setMax(LocalDate.now());
        dateOfSecondVaccination.setVisible(false);

        vaccinationStatus.addValueChangeListener(e -> {
            boolean vaccinated = "vaccinated".equals(e.getValue());
            vaccineTypeCombo.setVisible(vaccinated);
            numberOfVaccineDoses.setVisible(vaccinated);
            dateOfFirstVaccination.setVisible(vaccinated);
            dateOfSecondVaccination.setVisible(vaccinated);
        });

        // Local travel
        returnedFromLocalTravel14Days = createRadioGroup("Have you returned from a local travel within the last 14 days?", true);
        dateOfLocalTravelStart = new DatePicker("Start date for local travel");
        dateOfLocalTravelStart.setMax(LocalDate.now());
        dateOfLocalTravelStart.setVisible(false);
        dateOfTravelEndLocal = new DatePicker("End date for local travel");
        dateOfTravelEndLocal.setMax(LocalDate.now());
        dateOfTravelEndLocal.setVisible(false);
        stateOfTravel = new ComboBox<>("State");
        stateOfTravel.setItems(stateData);
        stateOfTravel.setVisible(false);
        lgaOfTravel = new ComboBox<>("LGA");
        lgaOfTravel.setVisible(false);
        clientTravelAddressLocal = new TextField("Travel address");
        clientTravelAddressLocal.setVisible(false);

        stateOfTravel.addValueChangeListener(e -> {
            List<String> lgas = lgaData.getOrDefault(e.getValue(), Collections.emptyList());
            lgaOfTravel.setItems(lgas);
            lgaOfTravel.clear();
        });

        returnedFromLocalTravel14Days.addValueChangeListener(e -> {
            boolean show = "yes".equals(e.getValue());
            dateOfLocalTravelStart.setVisible(show);
            dateOfTravelEndLocal.setVisible(show);
            stateOfTravel.setVisible(show);
            lgaOfTravel.setVisible(show);
            clientTravelAddressLocal.setVisible(show);
        });

        // International travel
        returnedFromInternationalTravel14Days = createRadioGroup("Have you returned from international travel within the last 14days", true);
        dateOfInternationalTravelStart = new DatePicker("Start date for international travel");
        dateOfInternationalTravelStart.setMax(LocalDate.now());
        dateOfInternationalTravelStart.setVisible(false);
        dateOfInternationalTravelEnd = new DatePicker("End date for international travel");
        dateOfInternationalTravelEnd.setMax(LocalDate.now());
        dateOfInternationalTravelEnd.setVisible(false);
        countryOfTravel = new ComboBox<>("Country");
        countryOfTravel.setItems(countryData);
        countryOfTravel.setVisible(false);
        cityOfTravel = new ComboBox<>("Town/City");
        cityOfTravel.setVisible(false);
        clientTravelAddressInternational = new TextField("Travel address");
        clientTravelAddressInternational.setVisible(false);

        returnedFromInternationalTravel14Days.addValueChangeListener(e -> {
            boolean show = "yes".equals(e.getValue());
            dateOfInternationalTravelStart.setVisible(show);
            dateOfInternationalTravelEnd.setVisible(show);
            countryOfTravel.setVisible(show);
            cityOfTravel.setVisible(show);
            clientTravelAddressInternational.setVisible(show);
        });

        // Contact with suspected/confirmed case
        contactWithSuspectedConfirmedCase = createRadioGroup("In the past 14 days, have you had contact with suspected or confirmed Covid-19", true);
        epidOrNameOfCase = new TextField("Details of the case");
        epidOrNameOfCase.setVisible(false);

        contactWithSuspectedConfirmedCase.addValueChangeListener(e -> {
            boolean show = "yes".equals(e.getValue());
            epidOrNameOfCase.setVisible(show);
        });

        // Attended any event
        attendedAnyEvent = createRadioGroup("In the past 14 days, have you attended an event", true);
        gatheringTypeCombo = new ComboBox<>("Type of gathering");
        gatheringTypeCombo.setItems(gatheringType);
        gatheringTypeCombo.setVisible(false);
        startDateEvent = new DatePicker("Start date");
        startDateEvent.setMax(LocalDate.now());
        startDateEvent.setVisible(false);
        endDateEvent = new DatePicker("End date");
        endDateEvent.setMax(LocalDate.now());
        endDateEvent.setVisible(false);
        stateOfEvent = new ComboBox<>("State");
        stateOfEvent.setItems(stateData);
        stateOfEvent.setVisible(false);
        lgaOfEvent = new ComboBox<>("LGA");
        lgaOfEvent.setVisible(false);
        descriptionOfEvent = new TextField("Description of event");
        descriptionOfEvent.setVisible(false);

        stateOfEvent.addValueChangeListener(e -> {
            List<String> lgas = lgaData.getOrDefault(e.getValue(), Collections.emptyList());
            lgaOfEvent.setItems(lgas);
            lgaOfEvent.clear();
        });

        attendedAnyEvent.addValueChangeListener(e -> {
            boolean show = "yes".equals(e.getValue());
            gatheringTypeCombo.setVisible(show);
            startDateEvent.setVisible(show);
            endDateEvent.setVisible(show);
            stateOfEvent.setVisible(show);
            lgaOfEvent.setVisible(show);
            descriptionOfEvent.setVisible(show);
        });

        // Inpatient
        visitedOrAdmittedInpatient = createRadioGroup("Have you visited or been admitted to any inpatient health facility", true);
        dateHospitalVisitOrAdmission = new DatePicker("Date of visit or admission?");
        dateHospitalVisitOrAdmission.setMax(LocalDate.now());
        dateHospitalVisitOrAdmission.setVisible(false);
        addressHospitalVisitedOrAdmitted = new TextField("Address of hospital visited or admitted in?");
        addressHospitalVisitedOrAdmitted.setVisible(false);

        visitedOrAdmittedInpatient.addValueChangeListener(e -> {
            boolean show = "yes".equals(e.getValue());
            dateHospitalVisitOrAdmission.setVisible(show);
            addressHospitalVisitedOrAdmitted.setVisible(show);
        });

        // Outpatient
        visitOutpatient = createRadioGroup("Have you visited any outpatient health facility", true);
        dateHospitalVisit = new DatePicker("Date of visit");
        dateHospitalVisit.setMax(LocalDate.now());
        dateHospitalVisit.setVisible(false);
        addressHospitalVisited = new TextField("Address of hospital visited");
        addressHospitalVisited.setVisible(false);

        visitOutpatient.addValueChangeListener(e -> {
            boolean show = "yes".equals(e.getValue());
            dateHospitalVisit.setVisible(show);
            addressHospitalVisited.setVisible(show);
        });

        // Person outcome
        personOutcome = createRadioGroup("Person outcome", true, "alive", "dead");
        dateOfDeathOutcome = new DatePicker("Date of death");
        dateOfDeathOutcome.setMax(LocalDate.now());
        dateOfDeathOutcome.setVisible(false);

        personOutcome.addValueChangeListener(e -> {
            boolean show = "dead".equals(e.getValue());
            dateOfDeathOutcome.setVisible(show);
        });

        // Co-morbidity
        for (String[] option : comorbidityOption) {
            RadioButtonGroup<String> group = createRadioGroup(option[0], false);
            comorbidityGroups.put(option[1], group);
        }

        // Add all fields to the form
        form.add(
                vaccinationStatus,
                vaccineTypeCombo,
                numberOfVaccineDoses,
                dateOfFirstVaccination,
                dateOfSecondVaccination,
                returnedFromLocalTravel14Days,
                dateOfLocalTravelStart,
                dateOfTravelEndLocal,
                stateOfTravel,
                lgaOfTravel,
                clientTravelAddressLocal,
                returnedFromInternationalTravel14Days,
                dateOfInternationalTravelStart,
                dateOfInternationalTravelEnd,
                countryOfTravel,
                cityOfTravel,
                clientTravelAddressInternational,
                contactWithSuspectedConfirmedCase,
                epidOrNameOfCase,
                attendedAnyEvent,
                gatheringTypeCombo,
                startDateEvent,
                endDateEvent,
                stateOfEvent,
                lgaOfEvent,
                descriptionOfEvent,
                visitedOrAdmittedInpatient,
                dateHospitalVisitOrAdmission,
                addressHospitalVisitedOrAdmitted,
                visitOutpatient,
                dateHospitalVisit,
                addressHospitalVisited,
                personOutcome,
                dateOfDeathOutcome
        );
        for (RadioButtonGroup<String> group : comorbidityGroups.values()) {
            form.add(group);
        }

        return form;
    }

    private RadioButtonGroup<String> createRadioGroup(String label, boolean required, String... items) {
      RadioButtonGroup<String> group = new RadioButtonGroup<>(label);
      if (items.length > 0) {
        group.setItems(items);
      } else {
        group.setItems("yes", "no", "unknown");
      }
      if (required) {
        group.setRequired(true);
        group.setRequiredIndicatorVisible(true);
      }
      return group;
    }
  }
