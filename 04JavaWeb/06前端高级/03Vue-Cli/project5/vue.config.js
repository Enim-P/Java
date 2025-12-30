const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  // 暂时先关闭eslint语法检查
  lintOnSave:false
})
