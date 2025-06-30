<template>
  <div>
    <header class="bg-blue-600 text-white py-4 shadow">
      <div class="container mx-auto flex items-center justify-between">
        <NuxtLink to="/" class="text-2xl font-bold">Simple Blog</NuxtLink>
        <nav class="space-x-4">
          <NuxtLink to="/" class="hover:underline">홈</NuxtLink>
          <NuxtLink to="/posts/create" class="hover:underline"
            >글 작성</NuxtLink
          >
        </nav>
      </div>
    </header>
    <main class="min-h-[90vh]">
      <NuxtPage />
    </main>
    <footer class="bg-gray-100 text-gray-500 py-4 text-center text-sm">
      © 2025 Simple Blog. All rights reserved.
    </footer>
  </div>
</template>
