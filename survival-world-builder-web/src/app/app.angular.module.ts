import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from "@angular/core";

import { MatToolbarModule } from '@angular/material/toolbar'
import { MatIconModule } from '@angular/material/icon'
import { MatButtonModule } from '@angular/material/button'
import { MatSidenavModule } from '@angular/material/sidenav'
import { MatListModule } from '@angular/material/list'
import { MatCardModule } from '@angular/material/card'
import { MatProgressBarModule } from '@angular/material/progress-bar'

@NgModule({
    imports: [
        MatToolbarModule, 
        MatIconModule,
        MatButtonModule,
        MatListModule,
        MatCardModule,
        MatProgressBarModule
    ], 
    exports: [
        MatToolbarModule,
        MatIconModule,
        MatButtonModule,
        MatSidenavModule,
        MatListModule,
        MatCardModule,
        MatProgressBarModule
    ],
    schemas: [
        CUSTOM_ELEMENTS_SCHEMA
    ]
})
export class AppAngularModule {

}