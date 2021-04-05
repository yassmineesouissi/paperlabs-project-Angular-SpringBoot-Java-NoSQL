import { Component, Input, OnInit } from '@angular/core';
import { BlocEntity } from 'app/entities/BlocEntity';

@Component({
  selector: 'jhi-bloc-ar',
  templateUrl: './bloc-ar.component.html',
  styleUrls: ['./bloc-ar.component.scss']
})
export class BlocArComponent implements OnInit {
  @Input() bloc: BlocEntity;

  constructor() {}

  ngOnInit() {}
}
