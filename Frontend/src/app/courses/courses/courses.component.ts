import { CoursesService } from './../services/courses.service';
import { Component, OnInit } from '@angular/core';
import { Course } from '../model/course';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { MatDialog } from '@angular/material/dialog';
import { ErrorDialogComponent } from 'src/app/shared/componets/error-dialog/error-dialog.component';


@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss']
})
export class CoursesComponent implements OnInit {

  courses$: Observable<Course[]>; // Observable é uma função para que só será executada quando for chamada, ou seja, quando o componente for renderizado. O subscribe é chamado automaticamente pelo Angular quando o componente é renderizado.
  displayedColumns = ['_id', 'name', 'category'];

  // CoursesService: CoursesService;

  constructor(
    private coursesService: CoursesService, // injeção de dependência, ou seja, o Angular vai criar uma instância da classe CoursesService e injetar no construtor da classe CoursesComponent.
    public dialog: MatDialog // injeção de dependência, ou seja, o Angular vai criar uma instância da classe MatDialog e injetar no construtor da classe CoursesComponent.
  ) {

    // this.CoursesService = new CoursesService();
    this.courses$ = this.coursesService.list()
    .pipe(
      catchError(error =>{
        this.onError('Erro ao carregar cursos.');
        return of([])
      })
    );
  }

    onError(errorMsg: string) {
      this.dialog.open(ErrorDialogComponent, {
        data: errorMsg
    });
  }

  ngOnInit(): void {
  }

}
