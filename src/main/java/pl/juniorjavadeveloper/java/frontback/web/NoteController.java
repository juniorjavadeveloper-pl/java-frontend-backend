package pl.juniorjavadeveloper.java.frontback.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/notes")
public class NoteController {
    public static final Logger LOGGER = Logger.getLogger(NoteController.class.getName());
    private List<NoteModel> notes = new ArrayList<>();

    @GetMapping
    public String list() {
        LOGGER.info("list() = " + notes);
        return "notes/notes";
    }

    @GetMapping(value = "/create")
    public String createView(ModelMap modelMap) {
        NoteModel noteModel = new NoteModel();
        modelMap.addAttribute("note", noteModel);
        return "notes/create-note";
    }

    @PostMapping
    public String create(@Valid NoteModel noteModel) {
        LOGGER.info("create(" + noteModel + ")");
        notes.add(noteModel);
        return "redirect:/notes";
    }
}
