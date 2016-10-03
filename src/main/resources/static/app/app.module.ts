import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";

import {AppComponent} from "./app.component";
import {NoteService} from "./note.service";
import {HttpModule} from "@angular/http";
import {FormsModule} from "@angular/forms";

@NgModule({
    imports: [BrowserModule, HttpModule, FormsModule],
    declarations: [AppComponent],
    providers: [NoteService],
    bootstrap: [AppComponent]
})
export class AppModule {}