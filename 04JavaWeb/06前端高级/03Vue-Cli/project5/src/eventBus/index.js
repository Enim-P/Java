import Vue from 'vue';

import axios from 'axios';

// 通过Vue的原型对象注册中央事件总线
Vue.prototype.$bus = new Vue()

// 通过Vue的原型对象注册axios
Vue.prototype.$axios = axios