import {Injectable} from "@angular/core";
import {Headers, Http} from "@angular/http";

import "rxjs/add/operator/toPromise";

export interface Field {
    nome: string;
    valor: string;
}

export interface Note {
    id: number;
    campos: Field[]
}

@Injectable()
export class NoteService {

    private headers = new Headers({"Content-Type": "application/json"});
    private noteUrl = "api/note/";

    constructor(private http: Http) { }

    getNote(ordem: number): Promise<Note> {
        return this.http.get(this.noteUrl + ordem)
                .toPromise()
                .then(
                    response => {console.log(response.json()); return response.json() as Note}
                );
    }

    findByText(text: string, pagina: number): Promise<Note[]> {
        return this.http.get(this.noteUrl + "?text=" + text + "&page=" + pagina)
            .toPromise()
            .then(
                response => {console.log(response.json()); return response.json() as Note[]}
            )
    }

}