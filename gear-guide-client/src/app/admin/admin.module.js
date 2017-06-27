const moduleName = 'app.admin';

import AdminController from './admin.controller';
import AdminService from './admin.service';

angular.module(moduleName, [])
    .controller('adminController', AdminController)
    .service('adminService', AdminService);

export default moduleName;