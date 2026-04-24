"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
exports.__esModule = true;
exports.CoursesComponent = void 0;
var core_1 = require("@angular/core");
var rxjs_1 = require("rxjs");
var operators_1 = require("rxjs/operators");
var CoursesComponent = /** @class */ (function () {
    // CoursesService: CoursesService;
    function CoursesComponent(coursesService, dialog) {
        this.coursesService = coursesService;
        this.dialog = dialog;
        this.displayedColumns = ['_id', 'name', 'category'];
        // this.CoursesService = new CoursesService();
        this.courses$ = this.coursesService.list()
            .pipe(operators_1.catchError(function (error) {
            console.error(error);
            return rxjs_1.of([]);
        }));
    }
    CoursesComponent.prototype.onError = function () {
        this.dialog.open(DialogDataExampleDialog, {
            data: {
                animal: 'panda'
            }
        });
    };
    CoursesComponent.prototype.ngOnInit = function () {
    };
    CoursesComponent = __decorate([
        core_1.Component({
            selector: 'app-courses',
            templateUrl: './courses.component.html',
            styleUrls: ['./courses.component.scss']
        })
    ], CoursesComponent);
    return CoursesComponent;
}());
exports.CoursesComponent = CoursesComponent;
