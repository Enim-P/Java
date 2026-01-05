import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// vite的配置文件
// vite的内部使用的是rollup作为打包工具
// 传统的Vue脚手架工具使用的是webpack作为打包工具
export default defineConfig({
  plugins: [vue()],
})
