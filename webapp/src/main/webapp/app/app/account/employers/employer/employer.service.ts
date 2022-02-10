import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { ICompany } from 'app/shared/model/company.model';
import { IEmployer } from '../../../shared/model/employer.model';

type EntityResponseType = HttpResponse<ICompany>;
type EntityArrayResponseType = HttpResponse<ICompany[]>;

@Injectable({ providedIn: 'root' })
export class EmployerService {
  public resourceUrl = SERVER_API_URL + 'api/employers';
  public resourceSearchUrl = SERVER_API_URL + 'api/_search/employers';
  public resourceByUserLoginUrl = SERVER_API_URL + 'api/employers/user';

  constructor(protected http: HttpClient) {}

  create(company: ICompany): Observable<EntityResponseType> {
    return this.http.post<ICompany>(this.resourceUrl, company, { observe: 'response' });
  }

  update(company: ICompany): Observable<EntityResponseType> {
    return this.http.put<ICompany>(this.resourceUrl, company, { observe: 'response' });
  }

  find(id: string): Observable<EntityResponseType> {
    return this.http.get<ICompany>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<ICompany[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: string): Observable<HttpResponse<any>> {
    return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  search(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<ICompany[]>(this.resourceSearchUrl, { params: options, observe: 'response' });
  }

  searchEmployersByUser(userId: string, pageNumber: number, itemsPerPage: number): Observable<EntityArrayResponseType> {
    return this.http.get<IEmployer[]>(`${this.resourceByUserLoginUrl}/${userId}?pageNumber=${pageNumber}&itemsPerPage=${itemsPerPage}`, {
      observe: 'response'
    });
  }
}
