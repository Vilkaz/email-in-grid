package de.vilkas.emailingrid;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.renderers.HtmlRenderer;
import com.vaadin.ui.renderers.TextRenderer;

import java.util.Arrays;
import java.util.Collection;

@SpringUI
public class StartView extends UI {

    public static final String EMAIL_COLUMN = "emailColumn";
    public static final String LINK = "make link";
    public static final String TEXT = "make text";
    private boolean showAsLink;
    private Grid<Person> grid;
    private Button linkChangerBtn;

    @Override
    protected void init(final VaadinRequest request) {

        grid = new Grid<>();
        grid.addColumn(Person::getEmail, email -> "<a href='mailto:" + email + "bcc=max.m@example.org'>E-Mail with Blindcopy</a>" , new HtmlRenderer())
                .setId(EMAIL_COLUMN);
        Collection<Person> persons = Arrays.asList(new Person(1l, "Paul", "paul@imba.com"));
        grid.setItems(persons);
        setContent(grid);

        linkChangerBtn = new Button(TEXT, e -> changeRenderer());
        VerticalLayout mainLayout = new VerticalLayout(linkChangerBtn, grid);
        setContent(mainLayout);
    }

    private void changeRenderer() {
        final Grid.Column<Person, ?> emailColumn = grid.getColumn(EMAIL_COLUMN);
        if (showAsLink) {
            linkChangerBtn.setCaption(TEXT);
            emailColumn.setRenderer( email -> "<a href='mailto:" + email + "bcc=max.m@example.org'>E-Mail with Blindcopy</a>" , new HtmlRenderer());
        } else {
            linkChangerBtn.setCaption(LINK);
            emailColumn.setRenderer(new TextRenderer());
        }
        showAsLink = !showAsLink;
    }
}
