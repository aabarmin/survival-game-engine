import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-progressor',
  templateUrl: './app-progressor.component.html',
  styleUrls: ['./app-progressor.component.css']
})
export class AppProgressorComponent implements OnInit {
  @Input()
  enabled: boolean = false;

  constructor() { }

  ngOnInit(): void {
    
  }

}
