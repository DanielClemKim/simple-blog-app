<template>
  <form @submit.prevent="onSubmit" class="space-y-4 max-w-xl">
    <div>
      <label class="block mb-1 font-semibold">제목</label>
      <input v-model="title" required class="w-full border px-3 py-2 rounded" />
    </div>
    <div>
      <label class="block mb-1 font-semibold">내용</label>
      <textarea
        v-model="content"
        required
        rows="8"
        class="w-full border px-3 py-2 rounded"
      ></textarea>
    </div>
    <button
      type="submit"
      class="px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600"
    >
      작성
    </button>
    <div v-if="error" class="text-red-500 mt-2">{{ error }}</div>
  </form>
</template>

<script setup lang="ts">
const title = ref("");
const content = ref("");
const error = ref("");
const router = useRouter();
const route = useRoute();

const props = defineProps<{ editMode: boolean }>();

async function onSubmit() {
  error.value = "";
  const url = props.editMode
    ? `http://localhost:8080/api/posts/${route.params.id}`
    : "http://localhost:8080/api/posts";

  try {
    await $fetch(url, {
      method: props.editMode ? "PUT" : "POST",
      body: { title: title.value, content: content.value },
    });
    await router.push("/");
  } catch (err: any) {
    error.value = err?.data?.message || "오류가 발생했습니다.";
  }
}
</script>
