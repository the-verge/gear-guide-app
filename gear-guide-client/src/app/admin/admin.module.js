const moduleName = 'app.admin';

import AdminController from './admin.controller';
import AdminService from './admin.service';

angular.module(moduleName, [])
    .controller('adminController', AdminController)
    .service('adminService', AdminService)
    .constant('PLAYER', 'player-img')
    .constant('GUITAR', 'guitar-img')
    .constant('AMPLIFIER', 'amplifier-img');

export default moduleName;