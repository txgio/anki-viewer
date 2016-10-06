import {Component, OnInit} from "@angular/core";
import {NoteService, Note} from "./note.service";

@Component({
    selector: "my-app",
    templateUrl: "app/app.component.html"
})
export class AppComponent {

    ordem: number = 1;
    note: Note;
    filtro: string;
    notes: Note[];
    pagina: number = 1;

    constructor(private noteService: NoteService) { }

    carregarNote(): void {
        this.noteService.getNote(this.ordem).then(
            note => this.note = note
        );
    }

    proximo(): void {
        this.ordem++;
        this.carregarNote();
    }

    anterior(): void {
        this.ordem--;
        this.carregarNote();
    }

    filtrar(): void {
        this.noteService.findByText(this.filtro, this.pagina).then(
            notes => this.notes = notes
        )
    }

    paginaSeguinte(): void {
        this.pagina++;
        this.filtrar();
    }

    paginaAnterior(): void {
        this.pagina--;
        this.filtrar();
    }

    escolherNote(note: Note): void {
        this.note = note;
    }
}